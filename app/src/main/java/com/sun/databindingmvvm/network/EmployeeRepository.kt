package com.sun.databindingmvvm.network

import androidx.lifecycle.MutableLiveData
import com.sun.databindingmvvm.model.Employee
import com.sun.databindingmvvm.model.EmployeeDBResponse
import com.sun.databindingmvvm.network.RetrofitClient.getService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeRepository {
    private var employees: List<Employee>? = listOf()
    private val mutableLiveData =
        MutableLiveData<List<Employee>?>()

    fun getMutableLiveData(): MutableLiveData<List<Employee>?> {
        val userDataService = getService()
        val call: Call<EmployeeDBResponse?>? = userDataService!!.employees
        call?.enqueue(object : Callback<EmployeeDBResponse?> {
            override fun onResponse(
                call: Call<EmployeeDBResponse?>?,
                response: Response<EmployeeDBResponse?>
            ) {
                val employeeDBResponse: EmployeeDBResponse? = response.body()
                if (employeeDBResponse != null && employeeDBResponse.employee != null) {
                    employees = employeeDBResponse.employee
                    mutableLiveData.setValue(employees)
                }
            }

            override fun onFailure(call: Call<EmployeeDBResponse?>?, t: Throwable?) {}
        })
        return mutableLiveData
    }

    companion object {
        private const val TAG = "EmployeeRepository"
    }
}