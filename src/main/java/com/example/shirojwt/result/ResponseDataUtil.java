package com.example.shirojwt.result;

/**
 * ResponseDataUtil:返回的工具类,主要是方便返回的写法
 * 单纯的返回工具类,直接放在这个包
 *
 * @author zhangxiaoxiang
 * @date: 2019/07/13
 */
public class ResponseDataUtil {
    /**
     * 返回成功描述
     * @param msg
     * @return
     */
    public static ResponseData success(String msg){
        ResponseData ResponseData=new ResponseData();
        ResponseData.setCode(200);
        ResponseData.setMsg(msg);
        ResponseData.setData(null);
        return ResponseData;
    }

    /**
     * 返回成功描述和数据详情
     * @param msg
     * @param data
     * @return
     */
    public static ResponseData success(String msg,Object data){
        ResponseData ResponseData=new ResponseData();
        ResponseData.setCode(200);
        ResponseData.setMsg(msg);
        ResponseData.setData(data);
        return ResponseData;
    }

    /**
     * 返回失败的带code的异常
     * @param code
     * @param msg
     * @return
     */
    public static ResponseData failure(Integer code,String msg){
        ResponseData ResponseData=new ResponseData();
        ResponseData.setCode(code);
        ResponseData.setMsg(msg);
        ResponseData.setData(null);
        return ResponseData;
    }

    /**
     * 登录授权的异常
     * @param msg
     * @return
     */
    public static ResponseData authorizationFailed(String msg){
        ResponseData ResponseData=new ResponseData();
        ResponseData.setCode(401);
        ResponseData.setMsg(msg);
        ResponseData.setData(null);
        return ResponseData;
    }



    /**
     * 返回失败的描述信息
     * @param msg
     * @return
     */
    public static ResponseData failure(String msg){
        ResponseData ResponseData=new ResponseData();
        ResponseData.setCode(500);
        ResponseData.setMsg(msg);
        ResponseData.setData(null);
        return ResponseData;
    }

}
