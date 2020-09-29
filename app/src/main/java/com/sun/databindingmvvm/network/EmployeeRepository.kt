package com.sun.databindingmvvm.network

import androidx.lifecycle.MutableLiveData
import com.sun.databindingmvvm.model.Employee
import com.sun.databindingmvvm.model.EmployeeDBResponse
import com.sun.databindingmvvm.network.RetrofitClient.getService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeRepository {
    private var employees: List<Employee>? = listOf()
    private val mutableLiveData =
        MutableLiveData<List<Employee>?>()

    fun getMutableLiveData(): MutableLiveData<List<Employee>?> {
        val userDataService = getService()
        val call: Observable<EmployeeDBResponse?>? = userDataService!!.employees
        call?.subscribeOn(Schedulers.io())
            ?.subscribe (
                {
                    if (it?.employee != null) {
                        employees = it.employee
                        mutableLiveData.setValue(employees)
                    }
                } ,
                {

                }
            )
        return mutableLiveData
    }

    companion object {
        private const val TAG = "EmployeeRepository"
    }
}