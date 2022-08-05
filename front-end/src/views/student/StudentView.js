import * as React from "react";
import {useEffect, useState} from "react";
import {ListStudents} from "./ListStudents/ListStudents";
import axios from "axios";
import {Button} from "@mui/material";
import {AddStudent} from "./AddStudent/AddStudent";
import {toast} from "react-toastify";


export function StudentView() {

  const [students, setStudents] = useState([]);
  const [isAddStudentDialogOpen, setAddStudentDialogOpen] = useState(false);

  useEffect(() => {
    axios.get("/students")
      .then(student => setStudents(student.data))
  }, []);

  function addStudent(formState) {
    axios.post("/students", formState)
      .then(response => {
        const messageResponse = response.data;
        if (messageResponse.responseType === "SUCCESS") {
          toast.success(messageResponse.message);
          setAddStudentDialogOpen(false);
        }
      })
  }

  return (
    <div>
      <Button onClick={() => setAddStudentDialogOpen(true)}>Add Student</Button>
      <ListStudents students={students}/>
      <AddStudent isOpen={isAddStudentDialogOpen}
                  close={() => setAddStudentDialogOpen(false)}
                  addStudent={addStudent}
      />
    </div>
  )
}
