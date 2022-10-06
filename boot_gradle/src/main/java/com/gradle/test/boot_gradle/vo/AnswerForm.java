package com.gradle.test.boot_gradle.vo;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
