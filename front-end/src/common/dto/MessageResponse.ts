export interface MessageResponse {
  messageType: MessageType;
  message: string
}

export enum MessageType {
  SUCCESS = "SUCCESS", INFO = "INFO", WARNING = "WARNING", ERROR = "ERROR"
}
