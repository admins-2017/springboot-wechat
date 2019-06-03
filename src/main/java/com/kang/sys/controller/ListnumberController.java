package com.kang.sys.controller;


import com.kang.sys.service.IListnumberService;
import com.kang.utils.json.JSONResult;
import com.kang.utils.json.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-05-06
 */
@RestController
@RequestMapping("/listnumber")
public class ListnumberController {

    @Autowired
    IListnumberService listnumberService;

    @GetMapping("/{uid}/{buysale}")
    public JSONResult getNumber(@PathVariable Integer uid,@PathVariable Integer buysale){
        String numbers=listnumberService.findListNumber(uid,buysale);
        return JSONResult.ok(numbers);
    }
}
