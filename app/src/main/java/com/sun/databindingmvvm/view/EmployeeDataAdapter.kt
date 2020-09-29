package com.sun.databindingmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sun.databindingmvvm.R
import com.sun.databindingmvvm.databinding.ItemDataBinding
import com.sun.databindingmvvm.model.Employee


class EmployeeDataAdapter :
    RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder>() {

    private var employees: ArrayList<Employee>? = null

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): EmployeeViewHolder {
        val employeeListItemBinding: ItemDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.item_data, viewGroup, false
        )
        return EmployeeViewHolder(employeeListItemBinding)
    }

    override fun onBindViewHolder(
        employeeViewHolder: EmployeeViewHolder,
        i: Int
    ) {
        val currentStudent = employees!![i]
        employeeViewHolder.employeeListItemBinding.setEmployee(currentStudent)
    }

    override fun getItemCount(): Int {
        return if (employees != null) {
            employees!!.size
        } else {
            0
        }
    }

    fun setEmployeeList(employees: ArrayList<Employee>?) {
        this.employees = employees
        notifyDataSetChanged()
    }

    inner class EmployeeViewHolder(employeetListItemBinding: ItemDataBinding) :
        RecyclerView.ViewHolder(employeetListItemBinding.getRoot()) {
        val employeeListItemBinding: ItemDataBinding

        init {
            employeeListItemBinding = employeetListItemBinding
        }
    }
}