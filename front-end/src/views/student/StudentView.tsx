import {Button} from "@material-ui/core";
import {AddStudent, StudentModel} from "./AddStudent/AddStudent";
import {useEffect, useState} from "react";
import {StudentApi, StudentQueryResponse} from "./api/StudentApi";
import {StudentList} from "./StudentList/StudentList";


export function StudentView() {

  const [isAddStudentModalOpen, setAddStudentModelOpen] = useState(false);
  const [studentQueryResponses, setStudentQueryResponses] = useState<StudentQueryResponse[]>([]);

  const studentApi = new StudentApi();

  useEffect(() => {
    studentApi.getStudents()
      .then(data => setStudentQueryResponses(data));
  }, []);

  const addStudent = async (model: StudentModel) => {
    const messageResponse = await studentApi.addStudent(model);
    console.log(messageResponse.message);
    setAddStudentModelOpen(false);
  }

  return (
    <div>
      <Button color="primary" onClick={() => setAddStudentModelOpen(true)}>Add student</Button>
      <AddStudent isOpen={isAddStudentModalOpen}
                  handleClose={() => setAddStudentModelOpen(false)}
                  addStudent={addStudent}/>
      <StudentList students={studentQueryResponses}/>
    </div>
  );
}
