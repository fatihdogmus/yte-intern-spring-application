import React, {useEffect, useState} from "react";
import {StudentApi} from "./api/StudentApi";
import {StudentList} from "./StudentList/StudentList";


export function StudentView() {

  const studentApi = new StudentApi();

  const [students, setStudents] = useState([]);

  useEffect(() => {
    studentApi.getStudents()
      .then(data => setStudents(data))
  }, [])

  return (
    <div>
      <StudentList student={students}/>
    </div>
  );
}