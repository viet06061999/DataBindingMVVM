package com.example.databindingmvvm.data.source.remote

import com.example.databindingmvvm.data.model.EmployeeDBResponse
import io.reactivex.Observable

import retrofit2.http.GET

interface EmployeeDataService {
    @get:GET("users/?per_page=12&page=1")
    val employees: Observable<EmployeeDBResponse>
}