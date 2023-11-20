import 'package:flutter/material.dart';
import 'package:pudim_douro/screens/home.dart';
import 'package:pudim_douro/screens/login_screen.dart';
import 'package:pudim_douro/screens/history.dart';
import 'package:pudim_douro/screens/vote.dart';


class SideMenu extends StatelessWidget {
  const SideMenu({super.key});

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: const [
          MenuHeader(),
          MenuItems(),
        ],
      ),
    );
  }
}

class MenuHeader extends StatelessWidget {
  const MenuHeader({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return UserAccountsDrawerHeader(
      accountName: const Text('User Default'),
      accountEmail: const Text('user@teste.com'),
      currentAccountPicture: CircleAvatar(
        child: ClipOval(
          child: Image.asset('assets/images/user_default.png'),
        ),
      ),
      decoration: const BoxDecoration(
        image: DecorationImage(
          image: AssetImage('assets/images/background_default.jpg'),
          fit: BoxFit.cover,
          opacity: 150,
        ),
      ),
    );
  }
}

class MenuItems extends StatelessWidget {
  const MenuItems({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Wrap(
      children: [
        ListTile(
          leading: const Icon(Icons.home),
          title: const Text('Home'),
          onTap: () => Navigator.of(context).pushReplacement(
            MaterialPageRoute(
              builder: (context) => const Home(),
            ),
          ),
        ),
        ListTile(
          leading: const Icon(Icons.history), //Icons.create
          title: const Text('Histórico'),
          onTap: () => Navigator.of(context).push(
            MaterialPageRoute(
              builder: (context) => const History(),
            ),
          ),
        ),
        ListTile(
          leading: const Icon(Icons.how_to_vote),
          title: const Text('Votação'),
          onTap: () => Navigator.of(context).push(
            MaterialPageRoute(
              builder: (context) => const Vote(),
            ),
          ),
        ),
        const Divider(),
        ListTile(
          leading: const Icon(Icons.logout),
          title: const Text('Sair'),
          onTap: () => Navigator.of(context).pushReplacement(
            MaterialPageRoute(
              builder: (context) => LoginScreen(),
            ),
          ),
        ),
      ],
    );
  }
}