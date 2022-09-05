import * as React from "react";
import {useEffect, useState} from "react";
import {StudentApi} from "./api/StudentApi";
import ListStudents from "./ListStudents/ListStudents";
import {Button} from "@mui/material";
import AddStudent from "./AddStudent/AddStudent";

import {toast} from "react-toastify";

export default function StudentView() {

  const studentApi = new StudentApi();

  const [students, setStudents] = useState([]);
  const [isAddStudentModalOpen, setAddStudentModalOpen] = useState(false);

  useEffect(() => {
    fetchStudents();
  }, []);

  async function fetchStudents() {
    const response = await studentApi.getAllStudents();
    setStudents(response.data);
  }

  async function addStudent(formState) {
    const response = (await studentApi.addStudent(formState)).data;
    if (response.resultType === "SUCCESS") {
      toast.success(response.message);
      setAddStudentModalOpen(false);
    }
  }

  return (
    <div>
      <Button onClick={() => setAddStudentModalOpen(true)}>Add Student</Button>
      <ListStudents students={students}/>
      <AddStudent isOpen={isAddStudentModalOpen} close={() => setAddStudentModalOpen(false)} submit={addStudent}/>
    </div>
  );
}
