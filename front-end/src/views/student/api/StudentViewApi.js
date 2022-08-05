import axios from "axios";

export class StudentViewApi {
  getStudents() {
    return axios.get("/students");
  }

  addStudent(formState) {
    return axios.post("/students", formState);
  }
}
