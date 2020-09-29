package com.sun.databindingmvvm.network

import com.sun.databindingmvvm.model.EmployeeDBResponse
import retrofit2.Call

import retrofit2.http.GET

    interface EmployeeDataService {
        @get:GET("users/?per_page=12&page=1")
        val employees: Call<EmployeeDBResponse?>?
    }