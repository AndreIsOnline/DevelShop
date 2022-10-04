package kosmok.teamlebimbe.ecommerce.controller.response;


public class BaseResponse {
    private StatusEnum status = StatusEnum.OK;
    private String message;

    public BaseResponse() { }

    public BaseResponse(String errorMessage) {
        if (!(errorMessage == null || errorMessage.length() == 0)) {
            this.status = StatusEnum.KO;
        }
        this.message = errorMessage;
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
