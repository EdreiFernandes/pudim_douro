import 'package:flutter/material.dart';
import 'package:pudim_douro/widgets/side_menu.dart';

class History extends StatelessWidget {
  const History({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: const SideMenu(),
      appBar: AppBar(
        title: const Text('History'),
      ),
    );
  }
}