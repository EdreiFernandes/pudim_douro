import 'package:flutter/material.dart';
import 'package:pudim_douro/widgets/side_menu.dart';

class Winners{
  String first;
  String second;
  String third;

  Winners(
    this.first,
    this.second,
    this.third,
  );
}

class YearResume {
  String year;
  Winners winners;
  bool isExpanded;

  YearResume(
    this.year,
    this.winners,
    this.isExpanded,
  );
}

List<YearResume> getYearsResume() {
  return [
    YearResume('2022', Winners('Guga', 'Sol', 'Ninho'), false),
    YearResume('2021', Winners('Mãe', 'Fê', 'Guga'), false),
    YearResume('2020', Winners('Tia', 'Mãe', 'Ninho'), false),
  ];
}

class History extends StatefulWidget {
  const History({super.key});

  @override
  State<History> createState() => _HistoryState();
}

class _HistoryState extends State<History> {
  final List<YearResume> _yearsResume = getYearsResume();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: const SideMenu(),
      appBar: AppBar(
        title: const Text('History'),
      ),
      body: SingleChildScrollView(
        child: Container(
          child: _renderYearsResume(),
        ),
      ),
    );
  }

  Widget _renderYearsResume() {
    return ExpansionPanelList(
      expansionCallback: (int index, bool isExpanded) {
        setState(() {
          _yearsResume[index].isExpanded = !isExpanded;
        });
      },
      children: _yearsResume.map<ExpansionPanel>((YearResume yearResume) {
        return ExpansionPanel(
          headerBuilder: (BuildContext context, isExpanded) {
            return ListTile(
              title: Text(yearResume.year),
            );
          },
          body: Column(
            children: [
              ListTile(
                title: Text('1° - ${yearResume.winners.first}'),
              ),
              ListTile(
                title: Text('2° - ${yearResume.winners.second}'),
              ),
              ListTile(
                title: Text('3° - ${yearResume.winners.third}'),
              ),
            ],
          ),
          isExpanded: yearResume.isExpanded,
        );
      }).toList(),
    );
  }
}
