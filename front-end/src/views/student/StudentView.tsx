import {Button} from "@material-ui/core";
import {AddStudent, StudentModel} from "./AddStudent/AddStudent";
import {useEffect, useState} from "react";
import {StudentApi, StudentQueryResponse} from "./api/StudentApi";
import {StudentList} from "./StudentList/StudentList";
import {MessageType} from "../../common/dto/MessageResponse";
import {toast} from "react-toastify";


export function StudentView() {

  const [isAddStudentModalOpen, setAddStudentModelOpen] = useState(false);
  const [studentQueryResponses, setStudentQueryResponses] = useState<StudentQueryResponse[]>([]);

  const studentApi = new StudentApi();

  function fetchStudents() {
    studentApi.getStudents()
      .then(data => setStudentQueryResponses(data));
  }

  useEffect(() => {
    fetchStudents();
  }, []);

  const addStudent = async (model: StudentModel) => {
    const messageResponse = await studentApi.addStudent(model);
    console.log(messageResponse);
    if (messageResponse.messageType === MessageType.SUCCESS) {
      toast.success(messageResponse.message);
      setAddStudentModelOpen(false);
      fetchStudents();
    } else {
      toast.error(messageResponse.message);
    }
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
