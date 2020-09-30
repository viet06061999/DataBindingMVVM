package com.sun.databindingmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingmvvm.R
import com.example.databindingmvvm.databinding.ItemDataBinding
import com.example.databindingmvvm.data.model.Employee

class EmployeeDataAdapter(val listener: (Employee) -> Unit) :
    RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder>() {

    private var employees: MutableList<Employee> = mutableListOf()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        position: Int
    ): EmployeeViewHolder {
        val employeeListItemBinding: ItemDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.item_data,
            viewGroup,
            false
        )
        return EmployeeViewHolder(employeeListItemBinding)
    }

    override fun onBindViewHolder(
        employeeViewHolder: EmployeeViewHolder,
        position: Int
    ) {
        employeeViewHolder.onBind(position)
    }

    override fun getItemCount(): Int = employees.size


    fun setEmployeeList(employees: List<Employee>) {
        this.employees.clear()
        this.employees.addAll(employees)
        notifyDataSetChanged()
    }

    inner class EmployeeViewHolder(val employeetListItemBinding: ItemDataBinding) :
        RecyclerView.ViewHolder(employeetListItemBinding.root) {
        fun onBind(position: Int) {
            val currentStudent = employees[position]
            employeetListItemBinding.employee = currentStudent
            employeetListItemBinding.root.setOnClickListener {
                listener(currentStudent)
            }
        }
    }
}