import {Button} from "@material-ui/core";
import {AddStudent} from "./AddStudent/AddStudent";
import {useState} from "react";


export function StudentView() {

  const [isAddStudentModalOpen, setAddStudentModelOpen] = useState(false);

  return (
    <div>
      <Button color="primary" onClick={() => setAddStudentModelOpen(true)}>Add student</Button>
      <AddStudent isOpen={isAddStudentModalOpen} handleClose={() => setAddStudentModelOpen(false)}/>
    </div>
  );
}
