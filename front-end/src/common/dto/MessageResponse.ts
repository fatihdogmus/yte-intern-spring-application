export interface MessageResponse {
  messageType: MessageType;
  message: string
}

export enum MessageType {
  SUCCESS, INFO, WARNING, ERROR
}
