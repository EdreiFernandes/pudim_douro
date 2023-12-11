import 'package:flutter/material.dart';
import 'package:pudim_douro/screens/login_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    
    return MaterialApp(
      title: 'Pudim D\'Ouro',
      theme: ThemeData.dark(),
      home: LoginScreen(),
    );
  }
}
