import {StudentModel} from "../AddStudent/AddStudent";
import axios from "axios";
import {MessageResponse} from "../../../common/dto/MessageResponse";

export class StudentApi {

  async addStudent(studentModel: StudentModel): Promise<MessageResponse> {
    const response = await axios.post<MessageResponse>("/students", studentModel);
    return response.data;
  }
}
