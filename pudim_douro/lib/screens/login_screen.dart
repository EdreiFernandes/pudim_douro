import 'package:flutter/material.dart';
import 'package:flutter_login/flutter_login.dart';
import 'package:pudim_douro/http/webclients/login_webclient.dart';
import 'package:pudim_douro/models/login.dart';
import 'package:pudim_douro/models/signup.dart';
import 'package:pudim_douro/screens/home.dart';

class LoginScreen extends StatelessWidget {
  LoginScreen({super.key});
  final LoginWebClient _webClient = LoginWebClient();

  Duration get loginTime => const Duration(milliseconds: 2250);

  Future<String?> _authUser(LoginData data) {
    debugPrint('Name: ${data.name}, Password: ${data.password}');
    return Future.delayed(loginTime).then((_) {
      return _webClient.login(Login.fromLoginData(data));
    });
  }

  Future<String?> _signupUser(SignupData data) {
    debugPrint('Signup Name: ${data.name}, Password: ${data.password}');
    return Future.delayed(loginTime).then((_) {
      return _webClient.signup(Signup.fromSignupData(data));
    });
  }

  Future<String?> _recoverPassword(String name) { 
    debugPrint('Name: $name');
    return Future.delayed(loginTime).then((_) {
      return 'Sorry! This functionality is not yet available. Try again later, please! ;)';
    });
  }

  @override
  Widget build(BuildContext context) {
    return FlutterLogin(
      title: 'Pudim D`Ouro',
      onLogin: _authUser,
      onSignup: _signupUser,
      additionalSignupFields: const [
        UserFormField(keyName: 'Name'),
        UserFormField(keyName: 'Surname'),
        UserFormField(keyName: 'Nickname'),
        UserFormField(keyName: 'Token'),
      ],
      onSubmitAnimationCompleted: () {
        Navigator.of(context).pushReplacement(MaterialPageRoute(
          builder: (context) => const Home(),
        ));
      },
      onRecoverPassword: _recoverPassword,
    );
  }
}
