import 'package:flutter/material.dart';
import 'package:flutter_session_manager/flutter_session_manager.dart';
import 'package:pudim_douro/http/webclients/edition_webclient.dart';
import 'package:pudim_douro/models/edition.dart';
import 'package:pudim_douro/widgets/side_menu.dart';

class History extends StatefulWidget {
  const History({super.key});

  @override
  State<History> createState() => _HistoryState();
}

class _HistoryState extends State<History> {
  final EditionWebClient _webClient = EditionWebClient();
  List<Edition> editionHistory = List.empty();

  Future<List<Edition>> _loadHistory() async {
    bool hasHistoryOnSession = await SessionManager().containsKey('history');

    if (hasHistoryOnSession) {
      final List<dynamic> decodedJson = await SessionManager().get('history');

      return decodedJson.map((dynamic json) => Edition.fromJson(json)).toList();
    }

    return _webClient.getEditionHistory();
  }

  @override
  void initState() {
    _loadHistory().then((List<Edition> value) {
      setState(() {
        editionHistory = value;
      });
    });
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: const SideMenu(),
      appBar: AppBar(
        title: const Text('History'),
      ),
      body: SingleChildScrollView(
        child: Container(
          child: editionHistory.isNotEmpty
              ? _renderYearsResume()
              : const Padding(
                  padding: EdgeInsets.all(32.0),
                  child: Center(
                    child: Text("There is no data yet!"),
                  ),
                ),
        ),
      ),
    );
  }

  Widget _renderYearsResume() {
    return ExpansionPanelList(
      expansionCallback: (int index, bool isExpanded) {
        setState(() {
          editionHistory.elementAt(index).setIsExpanded(isExpanded);
        });
      },
      children: editionHistory.map<ExpansionPanel>((Edition yearResume) {
        return ExpansionPanel(
          headerBuilder: (BuildContext context, isExpanded) {
            return ListTile(
              title: Text(yearResume.editionYear),
            );
          },
          body: Column(
            children: [
              ListTile(
                title: Text('1° - ${yearResume.firstPlace}'),
              ),
              ListTile(
                title: Text('2° - ${yearResume.secondPlace}'),
              ),
              ListTile(
                title: Text('3° - ${yearResume.thirdPlace}'),
              ),
            ],
          ),
          isExpanded: yearResume.isExpanded,
        );
      }).toList(),
    );
  }
}
