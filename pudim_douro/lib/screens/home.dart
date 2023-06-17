import 'package:flutter/material.dart';

import '../widgets/score_table.dart';

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Pudim DOuro'),
        actions: const <Widget>[],
      ),
      body: ListView(
        children: [
          Column(
            children: [
              Container(
                margin: const EdgeInsets.symmetric(
                  horizontal: 50,
                  vertical: 15,
                ),
                child: const Image(
                  image: AssetImage('assets/images/logo_pudim.png'),
                ),
              ),
            ],
          ),
          const ScoreTable(),
        ],
      ),
    );
  }
}