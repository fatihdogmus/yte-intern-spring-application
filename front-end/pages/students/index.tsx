import {useEffect, useState} from "react";
import axios from "axios";

interface StudentResponse {
  name: string;
  surname: string;
  email: string;
  tcKimlikNo: string;
  studentNumber: string
}

export default function Index() {

  const [students, setStudents] = useState<StudentResponse[]>([]);

  useEffect(() => {
    const fetchStudents = async () => {
      const response = await axios.get<StudentResponse[]>("/api/students");
      console.log(response)
      setStudents(response.data);
    }
    fetchStudents();
  }, []);

  return (
    <>
      {students.map(student => {
        return (
          <>
            <div>Name: {student.name}</div>
            <div>Surname: {student.surname}</div>
            <div>Student Number: {student.studentNumber}</div>
          </>
        )
      })}
    </>
  )
}
