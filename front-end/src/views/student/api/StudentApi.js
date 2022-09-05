import axios from "axios";

export class StudentApi {

  getAllStudents() {
    return axios.get("/students");
  }

  addStudent(student) {
    return axios.post("/students", student);
  }
}
