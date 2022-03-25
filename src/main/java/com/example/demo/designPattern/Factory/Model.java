package com.example.demo.designPattern.Factory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

interface OnlyOneInterface{

    void sout(String soutSomething);

    List<String> getCode();
}

@Service
class Factory{

    private static final Map<Integer, OnlyOneInterface> whatService = new HashMap<>();
    private final List<OnlyOneInterface> services;

    public Factory(List<OnlyOneInterface> services) {
        this.services = services;
    }

    @PostConstruct
    public void initWhatService(){
        System.out.println("init interface");
        for (OnlyOneInterface oneInterface : services) {
            for (String code : oneInterface.getCode()) {
                whatService.put(Integer.valueOf(code), oneInterface);
            }
        }
    }

    public static OnlyOneInterface getService(int codeNum) {
        OnlyOneInterface onlyOneInterface = whatService.get(Integer.valueOf(codeNum));
        System.out.println("this onlyoneInterface : "+ onlyOneInterface.toString());
        return onlyOneInterface;
    }

}
@Service
class FirstService implements OnlyOneInterface{

    @Override
    public void sout(String soutSomething) {
        System.out.println("firstservice의 sout" + soutSomething );
    }

    @Override
    public List<String> getCode() {
        List<String> thisIs_firstService = Collections.singletonList(MyEnum.YOU.getCode());
        System.out.println(thisIs_firstService);
        return thisIs_firstService;
    }
}
@Service
class SecondService implements OnlyOneInterface{

    @Override
    public void sout(String soutSomething) {
        System.out.println("second의 sout " + soutSomething);
    }

    @Override
    public List<String> getCode() {
        List<String> thisIs_secondservice = Collections.singletonList(MyEnum.MY.getCode());
        System.out.println(thisIs_secondservice);
        return thisIs_secondservice;
    }
}

@AllArgsConstructor
enum MyEnum{
    MY("19","my"),
    YOU("29","you");

    private final String code;
    private final String name;

    public String getCode(){
        return code;
    }

}
@Data
class Code{

    private int code;
}
@Service
class My{

    public void doThis(int codeNum){
        Code callMethod = new Code();
        callMethod.setCode(codeNum);
        OnlyOneInterface service = Factory.getService(callMethod.getCode());
        System.out.println("this service is shape of this ==== " + service.toString());
        service.sout("which one souted");
    }
}


@RestController
@RequiredArgsConstructor
public class Model {

    private final My my;

    @GetMapping("/hi")
    public void start() {
        my.doThis(19);
    }

}
