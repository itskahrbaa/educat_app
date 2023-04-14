package com.kahrbaa.educat

data class Course(val titleCourse: String,val description:String,val inProgress:Int,val createBy: WhoCreated)
data class WhoCreated(val name:String, val image:Int)
