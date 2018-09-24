package com.zzp.controller;

import com.zzp.pojo.Result;
import com.zzp.pojo.UserInfo;
import com.zzp.util.ExceptionEnum;
import com.zzp.util.ExceptionHandle;
import com.zzp.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by zhuzhengping on 2017/5/7.
 */
@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ExceptionHandle exceptionHandle;

    /**
     * 返回体测试
     * @param
     * @return
     */
    @RequestMapping(value = "/getResult",method = RequestMethod.POST)
//    @PostMapping("/getResult")
    public Result getResult(@RequestBody HashMap<String, String> map){
        String name= map.get("name");
        Result result = ResultUtil.success();
        try {
            if (name.equals("zzp")){
                result =  ResultUtil.success(new UserInfo());
            }else if (name.equals("pzz")){
                result =  ResultUtil.error(ExceptionEnum.USER_NOT_FIND);
            }else{

                int i = 1/0;

            }


        }catch (Exception e){

            result =  exceptionHandle.exceptionGet(e);
        }

        return result;
    }

}
