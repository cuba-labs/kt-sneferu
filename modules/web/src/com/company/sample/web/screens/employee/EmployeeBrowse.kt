package com.company.sample.web.screens.employee

import com.haulmont.cuba.gui.screen.*
import com.company.sample.entity.Employee

@UiController("sample_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
class EmployeeBrowse : StandardLookup<Employee>()