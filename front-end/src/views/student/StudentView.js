import * as React from "react";
import {useEffect, useState} from "react";
import {ListStudents} from "./ListStudents/ListStudents";
import {Button} from "@mui/material";
import {AddStudent} from "./AddStudent/AddStudent";
import {toast} from "react-toastify";
import {StudentViewApi} from "./api/StudentViewApi";


export function StudentView() {

  const [students, setStudents] = useState([]);
  const [isAddStudentDialogOpen, setAddStudentDialogOpen] = useState(false);

  const studentViewApi = new StudentViewApi();

  async function getStudents() {
    const response = await studentViewApi.getStudents();
    setStudents(response.data);
  }

  useEffect(() => {
    getStudents();
  }, []);

  async function addStudent(formState) {
    const response = await studentViewApi.addStudent(formState);
    const messageResponse = response.data;
    if (messageResponse.responseType === "SUCCESS") {
      toast.success(messageResponse.message);
      setAddStudentDialogOpen(false);
    }
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
