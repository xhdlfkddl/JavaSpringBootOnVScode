export default interface ResponseDto<Data> {
    result: boolean;
    message: String;
    data: Data | null;
}