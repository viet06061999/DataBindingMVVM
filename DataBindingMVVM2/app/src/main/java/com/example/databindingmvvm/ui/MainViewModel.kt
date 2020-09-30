package com.example.databindingmvvm.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.databindingmvvm.data.model.Employee
import com.example.databindingmvvm.data.repository.EmployeeRepository
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    application: Application,
    private val employeeRepository: EmployeeRepository
) : AndroidViewModel(application) {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _allEmployees = MutableLiveData<List<Employee>>()
    val allEmployee: LiveData<List<Employee>>
        get() = _allEmployees

    init {
        getEmployee()
    }

    private fun getEmployee() {
        _isLoading.value = true
        employeeRepository.getData()
            .subscribeOn(Schedulers.io())
            .subscribe(
                { _allEmployees.postValue(it.employee) },
                { it.stackTrace },
                { _isLoading.value = false }
            ).dispose()
    }
}