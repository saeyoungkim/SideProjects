enum ResponseResult{
    OK("200","Ok"),
    BAD_REQUEST("400", "Bad Request"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found");

    private String statusCode;
    private String status;

    ResponseResult(String statusCode, String status){
        this.statusCode = statusCode;
        this.status = status;
    }

    public String getStatusCode(){
        return this.statusCode;
    }

    public String getStatus(){
        return this.status;
    }
}