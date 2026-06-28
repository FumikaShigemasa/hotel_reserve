package com.example.demo.form.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented //API仕様書を自動出力する
@Constraint(validatedBy = { EmailDuplicationValidator.class }) //バリデータクラスを指定
@Target(ElementType.FIELD) //クラスレベルに制約
@Retention(RetentionPolicy.RUNTIME) //実行時にアノテーション情報を読み取れるようにする
public @interface EmailDuplication {

	//エラーメッセージを指定
	String message() default "登録済みのメールアドレスです";

	//バリデーショングループを指定
	Class<?>[] groups() default {};

	//エラーに付加情報を持たせる
	Class<? extends Payload>[] payload() default {};

	//使用する項目を指定
	String email();

	//1つのフィールドに同じアノテーションを複数使えるようにする
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public static @interface List {
		Password[] value();
	}
}
