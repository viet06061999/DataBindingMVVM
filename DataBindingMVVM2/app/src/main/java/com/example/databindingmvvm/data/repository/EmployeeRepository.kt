package com.example.databindingmvvm.data.repository

import com.example.databindingmvvm.data.model.EmployeeDBResponse
import com.example.databindingmvvm.data.source.remote.EmployeeDataService
import io.reactivex.Observable

class EmployeeRepository(private val employeeDataService: EmployeeDataService) {

    fun getData(): Observable<EmployeeDBResponse> = employeeDataService.employees

    companion object {
        private const val TAG = "EmployeeRepository"
    }
}