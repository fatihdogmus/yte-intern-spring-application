import {DataGrid} from "@material-ui/data-grid";
import {StudentQueryResponse} from "../api/StudentApi";


const tableColumns = [
  {field: "id", headerName: "ID", width: 120},
  {field: "firstName", headerName: "First Name", width: 200},
  {field: "lastName", headerName: "Last Name", width: 200},
  {field: "email", headerName: "E-mail", width: 200},
  {field: "tcKimlikNumber", headerName: "TC Kimlik Number", width: 200},
  {field: "studentNumber", headerName: "Student Number", width: 200}
];

interface Props {
  students: StudentQueryResponse[]
}

export function StudentList(props: Props) {

  console.log(props.students)

  return (
    <div style={{height: 400, width: '100%'}}>
      <DataGrid columns={tableColumns} rows={props.students} pageSize={5}/>
    </div>
  );
}
