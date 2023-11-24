import 'package:flutter_login/flutter_login.dart';

class Signup {
  final String email;
  final String name;
  final String surname;
  final String nickname;
  final String password;
  final String token;
  

  Signup(
    this.email,
    this.name,
    this.surname,
    this.nickname,
    this.password,
    this.token,
  );

  @override
  String toString() {
    return 'Signup{email: $email, name: $name, surname: $surname, nickname: $nickname, password: $password, token: $token}';
  }

  Signup.fromSignupData(SignupData signupData)
      : email = signupData.name.toString(),
        name = (signupData.additionalSignupData?["Name"]).toString(),
        surname = (signupData.additionalSignupData?["Surname"]).toString(),
        nickname = (signupData.additionalSignupData?["Nickname"]).toString(),
        password = signupData.password.toString(),
        token = (signupData.additionalSignupData?["Token"]).toString();

  Map<String, dynamic> toJson() => {
        'email': email,
        'name': name,
        'surname': surname,
        'nickname': nickname,
        'password': password,
        'token': token,
      };
}
