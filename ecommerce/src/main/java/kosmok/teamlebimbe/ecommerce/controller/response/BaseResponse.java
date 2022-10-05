package kosmok.teamlebimbe.ecommerce.controller.response;


public class BaseResponse {
    private StatusEnum status = StatusEnum.OK;
    private String message;

    public BaseResponse() { }

    public BaseResponse(String errorMessage, String okMessage) {
        if (!(errorMessage == null || errorMessage.length() == 0)) {
            this.status = StatusEnum.KO;
            this.message = errorMessage;
        } else if ((!(okMessage == null || okMessage.length() == 0))) {
            this.status = StatusEnum.OK;
            this.message = okMessage;
        }

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
