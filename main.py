from group_management import *
def main():
    choice = input("Search by course number (C), group name (G), or professor name (P)? ").upper()
    if choice == "C":
        course_number = input("Enter the course number: ")
        if search_course(course_number):
            group = input("Enter the group you want to join: ")
            join_group_by_course(course_number, group)
    elif choice == "G":
        group_name = input("Enter the group name: ")
        search_group(group_name)
        if input("Do you want to join this group? (Y/N): ").upper() == "Y":
            join_group_by_name(group_name)
    elif choice == "P":
        professor_name = input("Enter the professor's name: ")
        if search_professor(professor_name):
            join_group_by_professor(professor_name)
    else:
        print("Invalid choice.")
if __name__ == "__main__":
    main()
