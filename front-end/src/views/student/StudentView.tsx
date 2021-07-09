import {Button} from "@material-ui/core";
import {AddStudent, StudentModel} from "./AddStudent/AddStudent";
import {useState} from "react";
import {StudentApi} from "./api/StudentApi";


export function StudentView() {

  const [isAddStudentModalOpen, setAddStudentModelOpen] = useState(false);

  const studentApi = new StudentApi();

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
    </div>
  );
}
