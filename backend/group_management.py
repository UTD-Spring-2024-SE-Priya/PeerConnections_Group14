course_groups = {
    "CS3354": ["Group A", "Group B", "Group C"],
    "CS202": ["Group X", "Group Y", "Group Z"],}
group_members = {
    "Group A": ["John", "Alice", "Bob"],
    "Group B": ["Emily", "David", "Sophia"],
    "Group C": ["Michael", "Emma", "James"],}
def search_course(course_number):
    if course_number in course_groups:
        print("Available groups for course", course_number + ":")
        for group in course_groups[course_number]:
            print(group)
        return True
    else:
        print("Course not found.")
        return False
def join_group_by_course(course_number, group):
    if course_number in course_groups and group in course_groups[course_number]:
        print("You have successfully joined group", group, "for course", course_number + ".")
    else:
        print("Invalid course number or group.")
def search_group(group_name):
    found = False
    for course, groups in course_groups.items():
        if group_name in groups:
            print("Group", group_name, "is available for course", course + ".")
            found = True
    if not found:
        print("Group not found.")
def join_group_by_name(group_name):
    found = False
    for course, groups in course_groups.items():
        if group_name in groups:
            print("You have successfully joined group", group_name, "for course", course + ".")
            found = True
            break
    if not found:
        print("Invalid group name.")
def search_professor(professor_name):
    found_groups = []
    for group, members in group_members.items():
        if professor_name in members:
            found_groups.append(group)
    if found_groups:
        print("Professor", professor_name, "is available in the following groups:")
        for group in found_groups:
            print(group)
        return found_groups
    else:
        print("Professor not found in any group.")
        return None
def join_group_by_professor(professor_name):
    groups = search_professor(professor_name)
    if groups:
        group_choice = input("Enter the group you want to join: ")
        if group_choice in groups:
            print("You have successfully joined group", group_choice + ".")
        else:
            print("Invalid group choice.")
