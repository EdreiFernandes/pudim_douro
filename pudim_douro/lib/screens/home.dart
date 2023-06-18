import 'package:flutter/material.dart';
import 'package:pudim_douro/widgets/side_menu.dart';

import '../widgets/scoreboard.dart';

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: const SideMenu(),
      appBar: AppBar(
        title: const Text('Pudim DOuro'),
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
                child: Image.asset('assets/images/logo_pudim.png'),
              ),
            ],
          ),
          const Scoreboard(),
        ],
      ),
    );
  }
}
