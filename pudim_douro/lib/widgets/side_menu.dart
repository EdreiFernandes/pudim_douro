import 'package:flutter/material.dart';
import 'package:pudim_douro/screens/home.dart';
import 'package:pudim_douro/screens/login_screen.dart';

class SideMenu extends StatelessWidget {
  const SideMenu({super.key});

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          const UserHeader(),
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
            leading: const Icon(Icons.create),
            title: const Text('Placeholder'),
            onTap: () => Navigator.of(context).push(
              MaterialPageRoute(
                builder: (context) => const Placeholder(),
              ),
            ),
          ),
          const Divider(),
          ListTile(
            leading: const Icon(Icons.logout),
            title: const Text('Sair'),
            onTap: () => Navigator.of(context).pushReplacement(
              MaterialPageRoute(
                builder: (context) => const LoginScreen(),
              ),
            ),
          ),
        ],
      ),
    );
  }
}

class UserHeader extends StatelessWidget {
  const UserHeader({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return UserAccountsDrawerHeader(
      accountName: const Text('User'),
      accountEmail: const Text('user@teste.com'),
      currentAccountPicture: CircleAvatar(
        child: ClipOval(
          child: Image.asset('assets/images/logo_pudim.png'),
        ),
      ),
      decoration: const BoxDecoration(
        image: DecorationImage(
          image: AssetImage('assets/images/logo_pudim.png'),
          fit: BoxFit.cover,
        ),
      ),
    );
  }
}
