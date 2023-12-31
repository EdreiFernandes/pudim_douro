import 'package:flutter/material.dart';
import 'package:flutter_session_manager/flutter_session_manager.dart';
import 'package:pudim_douro/models/user.dart';
import 'package:pudim_douro/screens/home.dart';
import 'package:pudim_douro/screens/login_screen.dart';
import 'package:pudim_douro/screens/history.dart';

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

  Future<User> _getloggedUser() async {
    dynamic userJson = await SessionManager().get('user');
    User user = User.fromJson(userJson);
    return user;
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: _getloggedUser(),
        builder: (context, loggedUser) {
          return UserAccountsDrawerHeader(
            accountName: Text(loggedUser.data?.name ?? ''),
            accountEmail: Text(loggedUser.data?.email ?? ''),
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
        });
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
          title: const Text('History'),
          onTap: () => Navigator.of(context).push(
            MaterialPageRoute(
              builder: (context) => const History(),
            ),
          ),
        ),
        ListTile(
          leading: const Icon(Icons.how_to_vote),
          title: const Text('Vote'),
          //#region Disable vote
          onTap: () => availabilitySoonNotice(context),
          textColor: Colors.grey,
          iconColor: Colors.grey,
          // Route to vote page
          // onTap: () => Navigator.of(context).push(
          //   MaterialPageRoute(
          //     builder: (context) => const Vote(),
          //   ),
          // ),
          //#endregion
        ),
        const Divider(),
        ListTile(
          leading: const Icon(Icons.logout),
          title: const Text('logout'),
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

// temporary class
Future<String?> availabilitySoonNotice(context) {
  return showDialog<String>(
    context: context,
    builder: (BuildContext context) => AlertDialog(
      title: const Text('Available soon'),
      content: const Text(
          'Sorry!\n\nThis functionality is not yet available.\n\nTry again later, please! ;)'),
      actions: <Widget>[
        TextButton(
          onPressed: () => Navigator.pop(context, 'OK'),
          child: const Text('OK'),
        ),
      ],
    ),
  );
}