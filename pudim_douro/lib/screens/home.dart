import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Pudim De Ouro'),
        actions: const <Widget>[],
      ),
      body: const Image(
        image: AssetImage('assets/images/logo_pudim.png'),
      ),
    );
  }
}
