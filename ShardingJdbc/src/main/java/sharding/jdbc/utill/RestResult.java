package sharding.jdbc.utill;


import java.io.Serializable;
import java.util.HashMap;

/**
 * REST API统一结果对象.
 *
 * @author guoganbiao
 */
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 返回代码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 返回对象
     */
    private T payload;

    public RestResult() {
    }

    public RestResult(T object) {
        this(200, "success", object);
    }

    public RestResult(int code, String message) {
        setCode(code);
        setMessage(message);
    }

    public RestResult(int code, String message, T object) {
        setCode(code);
        setMessage(message);
        setPayload(object);
    }

    // -------------- private functions

    public static <T> RestResult build() {
        return new RestResult();
    }

    public static <T> RestResult success(T t) {
        RestResult result = success();
        result.setPayload(t);
        return result;
    }

    public static <T> RestResult success() {
        RestResult result = new RestResult();
        result.setCode(200);
        result.setMessage("成功");
        result.setPayload(new HashMap());
        return result;
    }

    public static <T> RestResult serverError() {
        RestResult result = new RestResult();
        result.setCode(999);
        result.setMessage("失败");
        result.setPayload(new HashMap());
        return result;
    }

    public static <T> RestResult serviceUnavailable() {
        RestResult result = new RestResult();
        result.setCode(999);
        result.setMessage("403");
        return result;
    }

    // ------------- getter/setters

    public static RestResult<String> create(int code, String message, Object token) {
        return RestResult.build().code(code).msg(message).payLoad(token);
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public RestResult code(int code) {
        this.setCode(code);
        return this;
    }


    public RestResult msg(String msg) {
        this.setMessage(msg);
        return this;
    }

    public RestResult payLoad(T payload) {
        this.setPayload(payload);
        return this;
    }

}
