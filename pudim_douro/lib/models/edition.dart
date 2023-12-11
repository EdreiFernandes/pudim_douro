class Edition {
  final String id;
  final String editionYear;
  final String active;
  final String firstPlace;
  final String secondPlace;
  final String thirdPlace;
  bool isExpanded;

  Edition(
    this.id,
    this.editionYear,
    this.active,
    this.firstPlace,
    this.secondPlace,
    this.thirdPlace,
    this.isExpanded,
  );

  Edition.fromJson(Map<String, dynamic> json)
      : id = json['id'],
        editionYear = json['edition_year'],
        active = json['active'],
        firstPlace = json['first_place'],
        secondPlace = json['second_place'],
        thirdPlace = json['third_place'],
        isExpanded = false;

  void setIsExpanded(bool isExpanded){
    this.isExpanded = isExpanded;
  }
}