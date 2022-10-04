package kosmok.teamlebimbe.ecommerce.controller.response;


public class BaseResponse {
    private StatusEnum status = StatusEnum.OK;
    private String message;

    public BaseResponse() { }

    public BaseResponse(String message) {
        if (!(message == null || message.length() == 0)) {
            this.status = StatusEnum.OK;
        }
        this.message = message;
    }



    public enum StatusEnum {
        OK, KO;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
