package com.company.sample.web.screens.employee

import com.haulmont.cuba.gui.screen.*
import com.company.sample.entity.Employee

@UiController("sample_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
class EmployeeEdit : StandardEditor<Employee>()