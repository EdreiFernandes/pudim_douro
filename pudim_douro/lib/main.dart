import 'package:flutter/material.dart';
import 'package:pudim_douro/http/webclients/user_weclient.dart';
import 'package:pudim_douro/screens/login_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  MyApp({super.key});
  final UserWebClient _webClient = UserWebClient();

  @override
  Widget build(BuildContext context) {
    print('Init');
    _webClient.test();

    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData.dark(),
      home: const LoginScreen(),
    );
  }
}
