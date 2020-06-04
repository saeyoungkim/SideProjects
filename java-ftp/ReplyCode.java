public enum ReplyCode{
    COMMAND_OK(200, "Command Okay."),
    COMMAND_NOT_IMPLEMENTED(502, "Command not implemented.");

    private int code;
    private String detail;

    private ReplyCode(int code, String detail){
        this.code = code;
        this.detail = detail;
    }

    public String toString(){
        return String.valueOf(this.code) + " " + this.detail + FtpServer.CRLF;
    }
}